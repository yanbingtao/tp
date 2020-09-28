---
layout: page
title: User Guide
---

tCheck is a desktop app that helps bubble tea store managers manage the staffs’ contact information, store’s inventory and historical sales data. It is optimized for CLI users to update and retrieve the information more efficiently.

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

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
  e.g. in `delete NAME`, `NAME` is a parameter which can be used as `delete John Doe`.

* Items in square brackets are optional.<br>
  e.g `search KEYWORD [MORE_KEYWORDS]` can be used as `search John White` or as `search John`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `sales A/NUM B/NUM C/NUM ……​` can be used as ` ` (i.e. 0 times), `sales BSBM/100`, `sales BSBM/100 BSBBT/120` etc.

</div>

### Viewing help : `help`

Shows a message explaning how to access the help page.

![help message](images/helpMessage.png)

Format: `help`


### Adding a contact Number: `add`

Adds a contact number to the contact list.

Format: `add NAME CONTACT [EMERGENCY_CONTACT]`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A person can have two possible contacts, one default contact and one emergency contact.
</div>

Examples:
* `add John 98765432`
* `add Betsy 94601960 82324598`

### Listing all persons : `list`

Shows a list of all persons in the address book.

Format: `list`

### Editing a person : `edit`

Edits an existing person in the address book.

Format: `edit INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`

* Edits the person at the specified `INDEX`. The index refers to the index number shown in the displayed person list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the person will be removed i.e adding of tags is not cumulative.
* You can remove all the person’s tags by typing `t/` without
    specifying any tags after it.

Examples:
*  `edit 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st person to be `91234567` and `johndoe@example.com` respectively.
*  `edit 2 n/Betsy Crower t/` Edits the name of the 2nd person to be `Betsy Crower` and clears all existing tags.

### Locating persons by name: `find`

Finds persons whose names contain any of the given keywords.

Format: `find KEYWORD [MORE_KEYWORDS]`

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

### Deleting a contact number : `delete`

Deletes the specified person from the contact list.

Format: `delete NAME`

* Deletes the person with the specified `NAME`.


Example:
* `delete John` deletes any entry with the name `John` from the contact list.

### Ingredients Tracking

#### Set Ingredient Level : `set`

* Users can initialise all ingredients levels to a standard default value or a desired value use a short command.

Format: `set all ingredients DEFAULT`

* Set all ingredient levels to the `DEFAULT` level, such as five units of the respective units.

Example:
* `set all ingredients 10`


* Users can enter all current ingredients level in a single command by following a pre-defined sequence.

Format: `set ingredients m/MILK b/BLACK_TEA s/SUGAR o/BUBBLE`

* Set all the level of milk left to `MILK` , the level of black tea left to `BLACK_TEA`, the level of sugar left to `SUGAR`, the level of bubble left to `BUBBLE`.

Example:
* `set ingredients m/10 b/12 s/5 o/30`


* Users can set the level for one type of ingredient individually.

Format: `set INGREDIENT_NAME AMOUNT`

* Set the `INGREDIENT_NAME` to the specified `AMOUNT`.

Example:
* `set milk 15`


<div markdown="span" class="alert alert-primary">:bulb: **Notice:**
Users inputs will be validated, if an invalid command is given, the program will show relevant error messages to notify the user to re-input.
Example of Error Message:  `No ingredient called ‘suger’ found !` .
</div>



### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

AddressBook data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Archiving data files `[coming in v2.0]`

_{explain the feature here}_

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Add** | `add NAME CONTACT [EMERGENCY_CONTACT]` <br> e.g., `add James 22224444` `add James 22224444 33335555`
**Clear** | `clear`
**Delete** | `delete NAME`<br> e.g., `delete James`
**Edit** | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`<br> e.g.,`edit 2 n/James Lee e/jameslee@example.com`
**Find** | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find James Jake`
**List** | `list`
**Help** | `help`
**Set all**  | `set all ingredients AMOUNT` <br> e.g., `set all ingredients 5`
**Set ingredients**  | `set ingredients m/MILK b/ BLACK_TEA s/ SUGAR o/BUBBLE` <br> e.g., `set ingredients m/19 b/20 s/5 o/0`
**Set**  | `set INGREDIENT_NAME AMOUNT` <br> e.g., `set milk 20`

