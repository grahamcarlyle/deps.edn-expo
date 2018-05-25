(ns hello-expo.core)

(def React (js/require "react"))
(def createElement (.-createElement React))

(def ReactNative (js/require "react-native"))
(def Text (.-Text ReactNative))
(def View (.-View ReactNative))
(def StyleSheet (.-StyleSheet ReactNative))

(def Expo (js/require "expo"))
(def registerRootComponent (.-registerRootComponent Expo))

(comment
  (ns hello-expo.core
    (:require [react :refer [createElement]]
              [react-native :refer [Text View]]
              [expo :refer [registerRootComponent]])))

(set! *warn-on-infer* true)

(def styles
  (.create StyleSheet
      (clj->js {:container {:flex 1
                            :backgroundColor "#fff"
                            :alignItems "center"
                            :justifyContent "center"}})))

(defn app-root []
  (createElement View #js {:style (.-container styles)}
    (createElement Text nil (str "Now is the time: " (js/Date.)))))

(registerRootComponent app-root)
