# RESTFUL API

- 기본 url /board

method | url | input | output
-:|:-:|:-:|:-
get|/{index}|index|page
get|/read/{index}|index|board
post|/create|name, pw, title, content|map
put|/update|idx, name, pw, title, content|map
delete|/delete|idx, name, pw|map

## output 형식

- page

content[  
    **board**  
]  
pageable{  
    sort{}  
    offset  
    pageSize  
    pageNumber  
    Paged  
    unpaged  
}  
last  
totalPages  
totalElements  
number  
size  
numberOfElements  
sort{  
    sorted  
    unsorted  
    empty  
}  
first  
empty  

- board  
  
idx  
name  
pw  
title  
content  
regdate  
modifydate  
  
- map  
  
message  
  