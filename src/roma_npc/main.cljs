(ns roma-npc.main
  (:require
    ;[reagent.core :as r]
    [roma-npc.components :refer [<button> <npc-card>]]
    [reagent.dom :as rdom]))

(def race-avatars
  {
   :dragonborn "https://www.dndbeyond.com/avatars/9/361/636327455772826858.jpeg"
   :dwarf      "https://www.dndbeyond.com/avatars/316/806/636620993762055484.jpeg"
   :elf        "https://www.dndbeyond.com/avatars/316/807/636620993866733375.jpeg"
   :gnome      "https://www.dndbeyond.com/avatars/316/811/636620994035528201.jpeg"
   :half-elf   "https://www.dndbeyond.com/avatars/9/381/636327459940259125.jpeg"
   :half-orc   "https://www.dndbeyond.com/avatars/9/385/636327460616726799.jpeg"
   :halfling   "https://www.dndbeyond.com/avatars/316/816/636620994265008086.jpeg"
   :human      "https://www.dndbeyond.com/avatars/316/819/636620994416798583.jpeg"
   :tiefling   "https://www.dndbeyond.com/avatars/9/388/636327461109911160.jpeg"
   :aasimar    "https://www.dndbeyond.com/avatars/19/478/636383057404991541.jpeg"
   })

(defn app
  []
  [:<>
  [:h1 "App"]
  [<button>
   {:variant "primary"
    :on-click #(prn "gen npc")}
   "Generate NPC"]
  [<npc-card> {:npc {:name   "Antonio Banderos"
                     :gender :male
                     :image  (:human race-avatars)
                     :race   :human}}]])

(defn render!
  []
  (rdom/render [app]
               (.getElementById js/document "app")))

(defn reload!
  []
  (render!))

(defn main! []
  (render!))
