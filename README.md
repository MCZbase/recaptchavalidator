# recaptchavalidator

Code to build recaptchavalidate-0.0.1-SNAPSHOT.jar to go into MCZbase cfusion/wwwroot/WEB-INF/lib directory to support MCZbase.MCZbase.aa375b1b  See MCZbase redmine issue 368.

Edit src/edu/harvard/mcz/recaptchavalidate/RecaptchaValidate.java to provide the key needed to validate responses.

Run maven package to build the jar file.

    mvn package

Then copy target/recaptchavalidate-0.0.1-SNAPSHOT.jar into the coldfusion cfusion/wwwroot/WEB-APP/lib directory (and add a javax-json jar) and restart coldfusion and apache to make captcha validation of bug submission by non-logged in MCZbase users (MCZbase commit aa37731b) available.
