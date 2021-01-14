
# SayTheTweet

Application de lecture de tweet

Pour faire fonctionner l'application, vous aurez besoin d'un compte twitter et d'un compte amazon polly.

Ensuite. Dans SearchTweets, modifiez dans getConfigurationBuilder() les identifiants par les votres.
Idem pour AmazonPollyClientImpl. 

Dans la classe SearchTweets, vous pouvez définir les Hashtag à rechercher. Actuellement, nous recherchons tous les tweets en lien avec le #Syrie. 

filterQuery.track("Сирия", "syria", "syrie", "syrien", "siria", "سوريا").filterLevel("none");

Attention. Lancer l'application dans un IDE peut bloquer le son. Si aucun son n'est audibles, démarrer l'application depuis un terminal en ligne de commande :

java -jar SayTheTweet.jar
