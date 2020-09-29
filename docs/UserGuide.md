---
layout: page
title: User Guide
---

tCheck is a desktop application that helps bubble tea store managers manage the staffs’ contact information, 
store’s inventory and historical sales data. It is optimized for CLI users to update and retrieve the information 
more efficiently.


* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start `[Release coming soon]`

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `addressbook.jar` from [here](https://github.com/se-edu/addressbook-level3/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your AddressBook.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`list`** : Lists all contacts.

   * **`add`**`n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01` : Adds a contact named `John Doe` to the Address Book.

   * **`delete`**`3` : Deletes the 3rd contact shown in the current list.

   * **`clear`** : Deletes all contacts.

   * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `ingredient NAME`, `NAME` is a parameter which can be used as `ingredient milk`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items with `…`​ after them can be used once or multiple times.<br>
  e.g. `sales A/NUM B/NUM C/NUM …` can be used as `sales BSBM/100` or `sales BSBM/100 BSBBT/120`.


* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

</div>

### Viewing help : `help`

Prints the list of commands, including the name, format and purpose of each command.

Format: `help`

### Ingredients Tracking
#### List Ingredient Levels : `ingredient list`
Prints the ingredient levels for all ingredient types retrieved from the database.

Format: `ingredient list`

#### View a Single Ingredient Level: `ingredient single`
Prints the ingredient level for a particular type of ingredient which is specified by the user’s command.

Format: `ingredient single INGREDIENT_NAME`

Example:
* `ingredient single milk`

#### Reset all to zero : `ingredient resetAll`
Sets all ingredient levels to 0 by updating the database when the command is entered.

Format: `ingredient resetAll`

#### Adding a person: `add`

Adds a person to the address book.

Format: `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A person can have any number of tags (including 0)
</div>

Examples:
* `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01`
* `add n/Betsy Crowe t/friend e/betsycrowe@example.com a/Newgate Prison p/1234567 t/criminal`

#### Listing all persons : `list`

Shows a list of all persons in the address book.

Format: `list`

#### Editing a person : `edit`

Edits the corresponding contact information in the contact list.

Format: `edit INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…​​`

* Edits the person at the specified `INDEX`. The index refers to the index number shown in the displayed person list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the person will be removed i.e adding of tags is not cumulative.
* You can remove all the person’s tags by typing `t/` without
    specifying any tags after it.

Examples:
*  `edit 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st person to be `91234567` and `johndoe@example.com` respectively.
*  `edit 2 n/Betsy Crower t/` Edits the name of the 2nd person to be `Betsy Crower` and clears all existing tags.


### Locating persons by keywords: `search`

Finds all contacts that contain the KEYWORD(s)

Format: `search KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `hans` will match `Hans`
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
* Only the name is searched.
* Only full words will be matched e.g. `Han` will not match `Hans`
* Persons matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`

Examples:
* `find John` returns `john` and `John Doe`
* `find alex david` returns `Alex Yeoh`, `David Li`<br>
  ![result for 'find alex david'](images/findAlexDavidResult.png)

#### Deleting a person : `delete`

Deletes the specified person from the address book.

Format: `delete INDEX`

* Deletes the person at the specified `INDEX`.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2` deletes the 2nd person in the address book.
* `find Betsy` followed by `delete 1` deletes the 1st person in the results of the `find` command.


### Archiving employees' contact details
#### Archiving a person : `archive`
Archives the specified employee's contact detail from the tCheck

Format: `archive INDEX`

* Archives the employee at the specified `INDEX`.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `archive 2` archives the 2nd person in the employees' contact details.
* `find Betsy` followed by `archive 1` deletes the 1st person in the results of the `find` command.

#### Archiving all employees' contact details : `archive all`
Archives all employees' contact detail from the tCheck

Format: `archive all`

#### Listing all archived employees' contact details : `archive list`
Shows a list of all archived employees' contact details in tCheck.

Format: `archive list`

#### Clearing all entries : `clear`

Clears all entries from the address book.

Format: `clear`

### Sales Tracking

#### Updating the number of drinks sold for the day
Asks the user to enter the number of each type of drink sold for the current day.

Format: `sales A/NUM B/NUM C/NUM ...`
* `A`, `B`, `C` are abbreviations for the drink types.
* `NUM` refers to the number of drinks sold

Example:
* `sales BSBM/100 BSBBT/120` Updates the sales of Brown Sugar Boba Milk `BSBM` to 100 and
 Brown Sugar Boba Black Tea `BSBBT` to 120.

#### Listing the number of drinks sold for the day
Shows a list of all types of drinks sold for the current day.

Format: `sales list`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

All tCheck data (i.e. contact details, ingredient data, sales data) are saved in the hard disk automatically after any
 command that changes the data. There is no need to save manually.

_{explain the feature here}_


## Command summary

### Employees' Contact Details
Action | Format, Examples
-------|------------------------------
**Add** | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​` <br> e.g., `add n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 t/friend t/colleague`
**Clear** | `clear`
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**Edit** | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`<br> e.g.,`edit 2 n/James Lee e/jameslee@example.com`
**Find** | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find James Jake`
**List** | `list`
**Archive** |  1. **Archive \(1 entry\):**  `archvie INDEX`<br> e.g., `archive 1` <br>2. **Archive \(all\):**  `archvie all` <br>3. **List all archived data:**  `archvie list`</br>
**Help** | `help`

### Sales Tracking
Action | Format, Examples
-------|------------------------------
**Update**| `sales A/NUM B/NUM C/NUM ...` <br> e.g., `sales BSBM/100 BSBBT/120`
**List**| `sales list`
 
