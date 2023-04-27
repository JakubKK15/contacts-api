# contacts-api
 A REST API that lets you manage contacts

# Description
This api connects to a MYSql database and manages contact information.
The information rows are: Name, Email, Address, and Phone Number
You can add a single or multiple contacts, you can also delete one or multiple contacts.
You can View them all at once, or only one, providing the id in the url.
You can edit existing contacts.

# Installation and usage instructions
You need to create a database on your machine, and call it "contactlist".
Then you need to provide your username, and password in application.properties.
After you do that, and the database is online, you can launch the API through ContactsApiApplication in src/main/java/com.jakubk.contactsapi
Then you can manage the contacts through an API tester. (I use Talend, it's a browser extension)
You can find the methods, mappings and URLs in ContactController.

# Contact
I tested everything, and it works fine. However, if you find anything make sure to contact me!
