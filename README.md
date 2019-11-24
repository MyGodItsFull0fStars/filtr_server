# filtr server side

## Description
This is the server side code for the filtr application.
filtr is a client-server application, in which processing of photos and audio will be done. 
The client-side will be realized using smartphones, which deliver pictures or audio files to the server. 
The server-side receives data from the client, and processes this data, depending on the desired processing. 
This can be for example, to filter a photo with a sepia effect. 
After the processing, the now transformed picture will be send back to the client, who can view, 
save and if desired do further processing on the data.


## Installation
1. Choose the server folder as your root folder.
2. Install all dependencies using `mvn clean install`.

### Problems fixed in Intellij
1. If for some reason, Intellij cannot load the maven dependencies, use `invalidate caches and restart` to solve this issue.
