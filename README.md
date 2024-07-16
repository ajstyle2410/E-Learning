# E-Learning
 Course Managment System
 
The Requirements
The design process always starts with gathering requirements. Our library system will have the following features:

A book catalog with search by the name, the author, and the category of the book. Note there may be more than one copy of each book, and a book may even be published by different publishers.
The ability to deactivate a patron's account if he/she does not return books after a specific period of time passes.
Records of books checked out as well as placed on hold (i.e., "reserved" by a patron to make sure the book is there when he/she gets to the library to check it out).
Notifications when the desired book becomes available and reminders that a book should be returned to the library, both by email.

# ---------------------------------------------------

Requirement 1: Book Catalog
Books and Authors
As books are the core element in the library system, our database needs to contain information about them and their authors. The most intuitive way is to create two tables: book and author.

Note that a single book may have more than one author and a single author may write more than one book. It is a MANY-TO-MANY RELATIONSHIP, so we need an additional table to connect the two. Let's call it book_author.

Let's think about the columns for a bit. A book has a title. An author has a name. We also need a PRIMARY KEY that allows us to identify each table row uniquely. So, we add an id column to each table.

To summarize, the table book will have the following columns:

id: the unique identifier and the primary key.
title: the title of the book.
The table author will have the following columns:

id: the unique identifier and the primary key.
name: the name of the author.
The table book_author will have the following columns:

book_id: the id of the book.
author_id: the id of the author.


The columns book_id and author_id together create a unique combination. For this reason, we do not need another artificial id column to act as a primary key. Instead, we use a composite primary key that consists of book_id and author_id.

#Categories
In our library, each book is assigned to a category. A book may belong to only one category: for example, "Adventure" or "Romance."

We create a new table category. This table needs only two columns:

id: the unique row identifier and the primary key.
name: the name of the category, for example, "Adventure."
Next, we need to connect it to the book table. Now, each book has a category_id column (foreign key) to let us identify the category to which it belongs. Note we use a one-to-many relationship.

#Book Copies
Our library may have multiple copies of the same book. A book may also be published by multiple publishers. To model this, we create two tables: book_copy and publisher.

The table publisher represents the publisher of the book. It consists of two columns:

id: the unique row identifier and the primary key.
name: the name of the publisher.
The table book_copy has the following columns:

id: the unique row identifier and the primary key.
year_published: the year in which the book was published.
book_id: a foreign key pointing to the corresponding row in the book
publisher_id: a foreign key, the id of the publisher of the book in the table publisher.

#Requirement 2: Patron Accounts
The book part is done. Now, we need people to check out our books! We need to store information about library patrons, such as first name, surname, and email. Each member has his or her own library card and an account which may be active or blocked (e.g., if the book is returned late).

We will use one table to store all this data: patron_account. It consists of the following columns:

card_number: the unique card number; it is also the primary key.
first_name: the patron's first name.
surname: the patron's last name.
email: the patron's email used for sending notifications.
status: active or blocked.
Right now, this table is not connected to any other table. We will add relationships in the following steps.

Requirement 3: Checkouts and Holds
We need a way for the patrons to check out or place a hold on (i.e., reserve) specific books. We will store records of checkouts and holds in two tables: checkout and hold. Let's look closely at each of them.

The table checkout has the following columns:

id: the unique row identifier and the primary key.
start_time: the timestamp when the book is checked out.
end_time: the timestamp when the book is returned.
book_copy_id: the id of the book copy that has been checked out.
patron_account_id: the id of the patron who has checked out the book.
is_returned: a Boolean field indicating whether or not the book has been successfully returned.
The table hold has the following columns:

id: the unique row identifier and the primary key.
start_time: the timestamp when the book is placed on hold.
end_time: the timestamp when the hold ends. This is either when the hold expires or when the book has been checked out.
book_copy_id: the id of the book copy that has been placed on hold.
patron_account_id: the id of the patron who has placed the hold.
Note the hold table is very similar to checkout. The main difference is that the is_returned flag is not present. Why is that?

With checkouts, we need a way to mark whether or not the book has been returned even past the due date (as the book return may be overdue). It is simpler with holds. When the book is checked out by the patron who has placed a hold on it, a checkout entry is created, and the hold end_time is set to the checkout start_time. If a patron does not check out the book in time, the hold simply expires. Nothing more needs to be done

#Requirement 4: Notifications
Waiting List
At times, all copies of a given book may be checked out or be on hold. The patrons may want to be placed on a waiting list and get notified when it becomes available. Let's see how this may be done.

We are going to create a table to save waiting list entries. Let's call it waitlist. This table will have only two columns:

patron_id: a foreign key, the id of the patron who wishes to check out the book.
book_id: a foreign key, the id of the book.
Note we use book_id and not book_copy_id here. This is because we do not know which copy will be available first. So, it makes sense to check all of them. On the other hand, the checkouts and holds are assigned to specific copies.

That said, you may need to create a system in which a patron can place a hold on a specific book, like a specific edition or translation. In this case, use book_copy_id or add columns such as publisher_id and year_published to the waitlist table. For our case, we will stick to book_id.

Notifications
Last but not least, we need to send notifications to our patrons: to remind them a book should be returned or to let them know the book they have been waiting for is now available in the library.

We need to create one additional table, notifications. This table will consist of the following columns:

id: the unique row identifier and the primary key.
sent_at: the timestamp when the notification is sent.
type: the notification type. For now, it is either a reminder to return the book or a notification that a certain book is available. In the future, we may have more options here.
patron_account_id: the ID pointing to the patron to be notified by email.
database design for library system

![model](https://github.com/user-attachments/assets/bfadb54a-506d-4deb-afd6-3ca8e82a6f16)

