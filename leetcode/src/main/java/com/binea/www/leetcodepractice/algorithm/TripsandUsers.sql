select Day, round(avg(cnt), 2) as "Cancellation Rate"
from
(   select a.request_at as Day,
    @cnt := IF(a.Status = 'completed', 0, 1) as cnt
    from Trips a, Users b
    where a.Client_Id = b.Users_Id and b.Banned = 'No'
) c
where Day BETWEEN '2013-10-01' AND '2013-10-03'
group by Day