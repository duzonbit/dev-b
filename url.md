# REQUEST

method | url | input | output
-:|:-:|:-:|:-
get|/|page|[board{idx,name,pw,title,content,regdate,modifydate}]
post|/create|name, pw, title, content|
get|/read|idx|{idx,name,pw,title,content,regdate,modifydate}
post|/update|idx, name, pw, title, content|
post|/delete|idx, name, pw|
