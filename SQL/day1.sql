SELECT 
    7 AS month,
    COUNT(DISTINCT a.user_id) AS monthly_active_users
FROM user_actions a
JOIN user_actions b
ON a.user_id = b.user_id
WHERE 
    a.event_date BETWEEN '2022-07-01' AND '2022-07-31'
    AND b.event_date BETWEEN '2022-06-01' AND '2022-06-30';