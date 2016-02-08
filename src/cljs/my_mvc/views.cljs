(ns my-mvc.views
    (:require [re-frame.core :refer [subscribe]]))

(defn main-panel    ;; the top level of our app
  []
  (let [name  (subscribe :name)]   ;; we need there to be good data
    (fn []
      [:div "Hello " @name])))

(defn top-panel    ;; this is new
  []
  (let [ready?  (subscribe [:initialised?])]
    (fn []
      (if-not @ready?         ;; do we have good data?
        [:div "Initialising ..."]   ;; tell them we are working on it
        [main-panel]))))      ;; all good, render this component