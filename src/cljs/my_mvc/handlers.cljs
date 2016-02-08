(ns my-mvc.handlers
    (:require
      [re-frame.core :refer [register-handler]]))

(register-handler
  :initialise-db             ;; usage: (dispatch [:initialise-db])
  (fn
    [_ _]                   ;; Ignore both params (db and v).
    {:name "My initialized name" ;; return a new value for app-db
     :items [1 2 3 4]}))