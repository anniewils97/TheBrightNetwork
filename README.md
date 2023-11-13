## The Bright NetWork Chatroom
 
We chat over the internet hundreds, sometimes thousands of times per day. Before Slack, Facebook, and Twitter were around, the real-time-communication niche of the internet was dominated by chatrooms. While you can emulate a more interesting and complex messaging platform (Discord, Slack, WhatsApp etc), you need to keep the scope of this project in mind, as a week is not a long time! A good way to approach this project is to start with the very basic “chatroom” MVP—where everyone can use any chat—and build up your extension functionality piece by piece.

### MVP

Below: input planning phase and our way of working, day 1 through 6(?).

-------------- edit above to suit MVP -----------------


### Key Functionality

Our program has the following functionalities:

* Allow for the creation of a new user
* Allow you to update the information of a user
* Delete a user
* Allow a user to post a message in a chatroom
* Allow a user to update their message
* Allow users to read messages sent by other users in a chatroom, most recent first
* Allow users to create a chatroom dependent on it having two members
* Display all existing chatrooms
* Display all users in a specific chatroom


### Dependencies and Context

* For posting a message: need to ensure user is in the chatroom first, before allowing them to post
* Depending on which class owns the relationship, for deleting a user or chatroom, will likely need if statements.


### Extensions

There are a few functionalities which would really add to the program but are not necessary for the running and execution of the program:

- Allow user to search a message within a chatroom by keyword
- Allow user to search a message across all chatrooms by keyword
- Allow users to react to a message
- Allow user to add a friend
- Create functionality that disables user from creating chatroom with other users that aren't in their friends' list


---------------- edit below to suit our MVP -------------

Also, the chatrooms in the MVP might all be public and available to anyone who has access to the API. You could add functionality that only allows specific people into chatrooms. There are a few ways to do this: whitelisting, blacklisting or password-protection to name a few, and these would require adding a password or lists of allowed/blocked players to the chatroom model.

If you really feel up for a challenge, you could research API authentication to get real login security but have a chat with the trainers ahead of attempting this.

### Flavours

The chatroom was an internet staple for group communication for years, but other flavours of communication have always taken the stage since. Communication platforms like WhatsApp do the job slightly differently, where a user has to be added by another user (often a group admin) if they want to join a group chat. You could look to implement this sort of feature.

In addition to this, you could look at having users first “agreeing” to message each other, in the form of friends (Facebook)—where the one user has to accept another user’s invitation—or it may come in the form of followers (Twitter) where there’s no strict invitation, but both parties have to follow each other to be able to message.

Remember that another group will be building a frontend for this API, and they may decide to take it in a direction that your team may not have thought about. Prioritise the basic functionality of a chatroom first before moving onto any extensions.
