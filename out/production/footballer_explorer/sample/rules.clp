(clear)
(reset)

(deftemplate categories
(slot Goal-Keeper)
(slot Center-Forward)
(slot Right-Back)
(slot Right-Wing)
(slot Left-Back)
(slot Left-Wing)
(slot Center-Back)
(slot Central-Midfield)
)

(deftemplate properties
(slot speed)
(slot jump)
(slot leg)
(slot long_pass)
(slot short_pass)
(slot shooting)
(slot dribbling)
(slot strength)
(slot heading)
(slot finishing)
(slot positioning)
(slot shoot_stopping)
(slot onetoone_situations)
(slot principles_of_attack)
(slot principles_of_defence)
(slot ball_control)
(slot running_with_the_ball)
(slot age)
)

(defrule rule_1
    (properties (jump High) (long_pass High) (shoot_stopping High))

=>

    (assert (categories (Goal-Keeper yes)))(printout t " This player is a Goal-Keeper" crlf))


(defrule rule_2
    (properties (heading High) (jump High))
=>
    (assert (categories (Center-Forward yes)))(printout t "This player is a Center-Forward" crlf))

