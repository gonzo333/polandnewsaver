<!-- Informacje podstawowe -->
## Informacje podstawowe

Aplikacja stworzona na potrzeby rekrutacji na szkolenie organizowane przez firmę Sages.

Przy pomocy Spring Boot'a stworzony został enpoint restowy **/api/news/buisness/poland/save**.

Wywołanie endpointa skutkuje pobraniem z API **https://newsapi.org** artykułów z kategorii buisness w języku polskim oraz zapisaniem ich do pliku _textFile.txt_ na dysku _C:/_  użytkownika.

Plik zapisany jest w formacie: title:description:author

## Testy aplikacji
Aby przetestować aplikację należy uruchomić ją na serwerze np. lokalnie poprzez intelij. **Ponieważ plik zapisywany jest na dysku C:/ należy idle z którego będziemy uruchamiać serwer aplikacyjny uruchomić jako administrator**

Aplikacja uruchamia się domyślnie na porcie 8080, zatem aby zapisać plik należy po uruchomieniu aplikacji wywołać klientem REST'owym następujący endpoint:
http://localhost:8080/api/news/buisness/poland/save

## Uwagi
Niestety, ponieważ ankieta rekrutacyjna miała zostać zakończona do poniedziałku (29.08.2022) brakło odrobinę czasu, aby zrefaktorować aplikację i napisać do niej testy jednostkowe.