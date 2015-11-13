(ns clerestory.core
  (:gen-class)
  (:use seesaw.core seesaw.font)
  (:import (org.fife.ui.rsyntaxtextarea RSyntaxTextArea SyntaxConstants
                                        TokenMakerFactory)	
           (org.fife.ui.rtextarea RTextScrollPane)))

(defonce appstate (ref {}))

(defn make-text-area []
  (let [area (RSyntaxTextArea.)]
    (doto area
      (.setAnimateBracketMatching true)
      (.setBracketMatchingEnabled true)
      (.setAutoIndentEnabled false)
      (.setAntiAliasingEnabled true)
      (.setLineWrap false)
      (.setFont (font :name "Menlo" :size 16)))
    area))

(defn make-listener []
  (let [win (frame :title "Listener" :minimum-size [512 :by 240])
        ed (make-text-area)]
    (.add win ed)
    (-> win pack! show!)
    win))

(defn -main [& args]
  (make-listener))
