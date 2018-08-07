curl \
-F "status=2" \
-F "notify=0" \
-F "ipa=StarWarsCharacterInfo/build/outputs/apk/StarWarsCharacterInfo-dev-debug.apk" \
-H "X-HockeyAppToken: 239a1780f9d44347928409370e36fe2c" \
https://rink.hockeyapp.net/api/2/apps/StarwarsExample/app_versions/upload