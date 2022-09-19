ЛР5

Роботу виконали студенти групи ІО-02:
- Воловик Олександр
- Литвиненко Данило
- Шумельчук Юрій

Варіант 16:
><b>Тема:</b> Оренда квартир
<br><b>Сутності:</b> Квартира, параметри квартири, опис
<br><b>Актори:</b> Хазяїн квартири, клієнт 
<br><b>Сценарії використання:</b> 
<br>Хазяїн квартири: Створення/редагування/видалення інформації про квартиру
<br>Клієнт: пошук квартири по параметрам

Тестування розробленого API на відповідність опису у документації за допомогою Postman:

GET /api/orders

![Screenshot](readme/1.png)
![Screenshot](readme/2.png)

GET /api/rooms (Фільтрація по параметрах та пагінація)

![Screenshot](readme/3.png)
![Screenshot](readme/4.png)
![Screenshot](readme/5.png)
![Screenshot](readme/6.png)
![Screenshot](readme/7.png)

POST /api/rooms

![Screenshot](readme/8.png)
![Screenshot](readme/9.png)
![Screenshot](readme/10.png)

GET /api/rooms/{id}

![Screenshot](readme/11.png)
![Screenshot](readme/20.png)
![Screenshot](readme/12.png)

PUT /api/rooms/{id}

![Screenshot](readme/13.png)
![Screenshot](readme/14.png)
![Screenshot](readme/15.png)
![Screenshot](readme/16.png)

DELETE /api/rooms/{id}

![Screenshot](readme/17.png)
![Screenshot](readme/18.png)
![Screenshot](readme/19.png)

Контрольні питання:

1. Поясніть різницю між JDBC та JdbcTemplate.
   > ssdf
2. Які переваги надає PreparedStatement у порівнянні зі звичайним Statement?
   > ssdf
3. Поясніть різницю між методами execute(), executeQuery() та executeUpdate() класу PreparedStatement.
   > ssdf
4. Чим відрізняються інтерфейси RowMapper<T> та ResultSetExtractor<T>?
   > ssdf
5. Для чого потрібен інтерфейс KeyHolder?
   > ssdf
6. Як працює декларативне керування транзакціями у Spring Framework?
   > ssdf
7. Що таке «transaction propagation»? Як обрати потрібний механізм поширення транзакцій? Який механізм поширення транзакцій використовується за замовченням?
   > ssdf