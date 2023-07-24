### Project requirements
-CRUD for cars
 - API urls
   - Read - GET
     - /cars - read all cars
     - list 200
     - /cars/{id}
     - one item/200
     - /client/{id}/cars/{id}
     - 404 not found
   - Creat - POST
     - /cars
     - 201/void/created item/ header location
   - Delete - DELETE
     - /cars/{id}
     - 200/content
     - 204/non-content
     - 404 - not found
   - Update
     - PUT - replace
       - /cars/{id}
       - 200/content
     - PATCH - partial update
       - /cars/{id}
       - 200/content
- lista aut
- - model
  - marka
    - rodzaj paliwa
    - opis silnika
    - typ auta/kategoria
    - ilość miejsc
    - pojemność bagażnika w litrach
    - spalanie
    - vin
    - cena w PLN
    - dostępność
    - zdjecia
    - zasieg km
  - opisy
  - vin
  - ceny
  - dostępność
  - zdjecia
  - zasieg km
    Wypożycznie
      - miejsce wypożyczenia
      - czas wypożyczenia
      - miejsce oddania
      - klient
      - auto
- wybor pojedynczego
- kontakt do firmy
- warunki prawne
- filtrowanie po właściwościach
- odnośniki do mediów społecznościowych
- jak długo klient ma prawo jazdy
- historia wypożyczeń
- płatności
- konta użytkoników
- dostępne ubezpieczenia
- admin/zwykły użytkownik
- potwierdzenie wypożyczenia auta
- aktywacja konta przy użyciu emaila


MVC -  Model View Controller

View        | View
Controller  | Controller
Model       | Service
            | Repository
