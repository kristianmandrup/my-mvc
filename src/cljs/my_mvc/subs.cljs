(ns my-mvc.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :refer [register-sub]]))

(register-sub
 :name
 (fn [db]
   (reaction (:name @db))))

(register-sub       ;; the means by which main-panel gets data
  :name             ;; usage (subscribe [:name])
  (fn  [db]
    (reaction (:name @db))))

(register-sub       ;; we can check if there is data
  :initialised?     ;; usage (subscribe [:initialised?])
  (fn  [db]
    (reaction (not (empty? @db)))))   ;; do we have data
