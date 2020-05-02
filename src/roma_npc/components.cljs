(ns roma-npc.components)

(defn <button>
  [{:keys [variant] :as attr} & content]
  [:button.nes-btn
   (merge {:type "button"
           :class (when variant
                    (str "is-" variant))}
          (dissoc attr :variant))
   content])
; <button type="button" class="nes-btn is-primary">Primary</button>

(defn <container>
  [attr & content]
  [:section.nes-container content])

(defn <message-list>
  [attr & content]
  [:section.message-list content])

(defn <avatar>
  [{:keys [rounded?]
    :or {rounded? true}
    :as attr}]
  [:img.nes-avatar
   (merge 
   {:class (when rounded?
             "is-rounded")}
   (dissoc attr :src :rounded?))]
;  <img class="nes-avatar is-rounded" alt="Gravatar image example" src="https://www.gravatar.com/avatar?s=15" style="image-rendering: pixelated;">
  )

(defn <balloon>
  [{:keys [pos]
    :or {pos "left"}
    :as attr}
   & content]
  [:div.nes-balloon
   {:class (str "from-" pos)}
   content])

(defn <message>
  [{:keys [pos]
    :or {pos "left"}
    :as attr} & content]
  [:section.message
   {:class (str "-" pos)}
   content])

(defn <npc-card>
  [{:keys [npc]
    :as attr}]
  (let [pos "left"
        {:keys [name race gender]} npc]
    [<container> {}
     [<message-list> {}
      [<message> {:pos pos}
       [<balloon>
        {:pos pos}
        [:p name]
        [:p gender]
        [:p race]]]]]))
