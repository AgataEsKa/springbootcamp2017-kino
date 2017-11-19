# Prace domowe

### Do zrobienia na 18.11:

* Przejrzyj listę commitów naprawiających błędy jakie były zawarte w momencie jak zakończyły się zajęcia.

Wyjaśnienie: aplikacja podczas wrzucania na Tomcata zgłaszała błąd inicjacji bazy danych (jakoby baza już istniała). Na skutek błędu konfiguracyjnego tak się stało. Dotychczas robiliśmy aplikację desktopową gdzie istniał jeden kontekst springa. Przy servletach wyróżna się dodatkowo kontekst servletu, który oprócz tego, że widzi nasz standardowy kontekst (root context), posiada własny kontekst controllerów (root context nie widzi kontekstu servletu). Niestety ComponentScan w inicjacji kontekstu servletu  spowodował, że załapała się w nim również klasa RootConfig.class co sprawiło, że kontekst ten został ponownie zbudowany w kontekście servletu. Spowodowało to próbę utworzenia jeszcze raz wszystkich beanów ze standardowego kontekstu w kontekście servletu. Niestety baza danych nie pozwoliła się ponownie zainicjować - stąd błędy. Więcej wyjaśnimy sobie na zajęciach.

Praca domowa:
* Dorób w widoku: http://localhost:8080/kino/accounts ostatnią przygotowaną kolumnę (Reservations) w której będzie liczba rezerwacji jaką posiada użytkownik. Dane te możesz pozyskać poprzez uzupełnienie Entity User o Set(Reservation) albo odpowiednim zapytaniem na ReservationDao (możesz przećwiczyć obie formy). W JSTL można napisać np. ${user.reservations.size()} - oczywiście gdy dorobicie to aby User posiadał takie pole.
* Przez podobieństwo do accounts - dorobić kolejne widoki jakie zasugerowałem w home.jsp
* Zaznajomić się z Bootstrapem (http://getbootstrap.com/docs/4.0/getting-started/introduction/) - rozdziały od Layout (z podrozdziałami) do Components (z podrozdziałami) - nasz system musi wyglądać pięknie! :)

### Do zrobienia na 25.11

Znacie już praktycznie cały proces wytwarzania aplikacji począwszy od projektowania baz danych, ich obsługi za pomocą narzędzi ORM. Potraficie wykonać całą logikę biznesową z użyciem **Spring Framework**. Potraficie również projektować warstwę prezentacji danych z użyciem JSP, Tiles. Umiecie generować widoki, przesyłać dane do modelu oraz pozyskiwać z niego dane poprzez GET, POST, ..., formularze, walidację. Na koniec dowiedzieliście się jak zabezpieczać naszą aplikację poprzez proces uwierzytelnienia użytkowników w systemie. Wykorzystajcie więc tą wiedzę na rozwinięcie naszej aplikacji.

Od zakończenie zająć dorobiłem przyciski **Zaloguj** oraz **Zarejestruj**. Funkcjonalności te już mieliśmy - jedynie dopuściłem do opcji zakładania konta użytkowników niezalogowanych. Więcej tutaj -> [Commit](https://github.com/cackoarek/springbootcamp2017-kino/commit/f2190f202caaa38518c951ba9010aa8eafc15fcb)

Oczywiście znów łyknęliście jak pelikany sposób logowania... który znów był zły :) Więcej tu: [Commit](https://github.com/cackoarek/springbootcamp2017-kino/commit/ff9da568690ce68ccbf227246029263c057b4069)

Wrzuciłem appkę na HEROKU. Można się bawić. Teraz wy przejmujecie aplikację - rozbudujcie ją.
 

Do zrobienia będzie (są to propozycje dla was):
- uzupełnić braki z poprzedniej pracy domowej
- wiecie jak już można trzymać i pozyskać role z bazy danych. Doróbcie więc kolejną kolumnę w bazie danych w tabeli **users** jako połączenie wiele-do-wielu z nową tabelą **roles**. Wykorzystajcie te dane do obsługi ról w systemie.
- na adresie **/admin/xxx** stworzyć kilka widoków np. dodawania filmów, pokoi, seansów. Dostęp do **/admin/** powinien mieć oczywiście osoba z uprawnieniami **ROLE_ADMIN**
- to admin przydziela prawa. Domyślnie jedyna rola jaką się pozyskuje to **ROLE_USER**
- zadbaj o to aby nie dało się stworzyć użytkownika o takim samym emailu

 
