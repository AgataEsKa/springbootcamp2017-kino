Do zrobienia na 18.11:

* Przejrzyj listę commitów naprawiających błędy jakie były zawarte w momencie jak zakończyły się zajęcia.

Wyjaśnienie: aplikacja podczas wrzucania na Tomcata zgłaszała błąd inicjacji bazy danych (jakoby baza już istniała). Na skutek błędu konfiguracyjnego tak się stało. Dotychczas robiliśmy aplikację desktopową gdzie istniał jeden kontekst springa. Przy servletach wyróżna się dodatkowo kontekst servletu, który oprócz tego, że widzi nasz standardowy kontekst (root context), posiada własny kontekst controllerów (root context nie widzi kontekstu servletu). Niestety ComponentScan w inicjacji kontekstu servletu  spowodował, że załapała się w nim również klasa RootConfig.class co sprawiło, że kontekst ten został ponownie zbudowany w kontekście servletu. Spowodowało to próbę utworzenia jeszcze raz wszystkich beanów ze standardowego kontekstu w kontekście servletu. Niestety baza danych nie pozwoliła się ponownie zainicjować - stąd błędy. Więcej wyjaśnimy sobie na zajęciach.

Praca domowa:
* Dorób w widoku: http://localhost:8080/kino/accounts ostatnią przygotowaną kolumnę (Reservations) w której będzie liczba rezerwacji jaką posiada użytkownik. Dane te możesz pozyskać poprzez uzupełnienie Entity User o Set(Reservation) albo odpowiednim zapytaniem na ReservationDao (możesz przećwiczyć obie formy). W JSTL można napisać np. ${user.reservations.size()} - oczywiście gdy dorobicie to aby User posiadał takie pole.
* Przez podobieństwo do accounts - dorobić kolejne widoki jakie zasugerowałem w home.jsp
* Zaznajomić się z Bootstrapem (http://getbootstrap.com/docs/4.0/getting-started/introduction/) - rozdziały od Layout (z podrozdziałami) do Components (z podrozdziałami) - nasz system musi wyglądać pięknie! :)
