(ns my-mvc.core
    (:require [reagent.core :as reagent]
              [re-frame.core :refer [dispatch dispatch-sync]]
              [my-mvc.handlers]
              [my-mvc.subs]
              [my-mvc.views :as views]
              [my-mvc.config :as config]))

(when config/debug?
  (println "dev mode"))

(defn mount-root []
  (reagent/render [views/top-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (dispatch [:initialise-db])   ;;  <--- this is new
  (mount-root))
