url /workflow_write подсчитывает количество запросов с таким числом, максимум два числа. Все последующие числа игнорируются, пока счетчик не сбросится
Флаг "reset_counter" используется для сброса подсчета. 

запрос post
    {
        "workflow_number": int
        "reset_counter": bool
    }

ответ

    {
        "workflow_one_counter": int,
        "workflow_two_counter": int,
    }
    

url /get_counter возвращает значения счетчика.

запрос get без тела

ответ
     {
         "workflow_number": int
         "reset_counter": bool
     }
