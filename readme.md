Deploy na HEROKU
===
Jest kilka "darmowych" serwisów do deployowania aplikacji webowych JAVA
- https://www.openshift.com/
- https://cloud.google.com/appengine/docs/
- https://dashboard.heroku.com

Zakładamy konto na HEROKU - darmowy plan 550h DYNO hours

Jedyne co potrzebujemy to:
0) Napisać własną aplikację
1) Zainstalować klienta Heroku
- https://stackoverflow.com/questions/9923486/steps-needed-to-deploy-war-on-heroku
- https://devcenter.heroku.com/articles/war-deployment#deployment-with-the-heroku-cli
- https://devcenter.heroku.com/articles/getting-started-with-java#introduction
2) Wyklikać aplikację
3) Deployment:
- heroku war:deploy --war kino-1.0-SNAPSHOT.war --app kino-sages


