url /workflow_write принимает интовое значение и
подсчитывает количество запросов с таким числом, максимум два числа.
Если приходит 3е число, то счетчик сбрасывается и начинается заново

запрос

{
"workflow_number": int
"reset_counter": bool
}

ответ

    {
        "workflow_one_counter": int,
        "workflow_two_counter": int,
    }
