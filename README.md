# Simple SQL Injection Attack Prevention 🛡️

## Overview

This project, conducted as part of the Software Security course, demonstrates both the vulnerability of SQL injection attacks and the effective use of PreparedStatements to prevent such attacks. The project includes sample code and printouts illustrating how user input can be exploited to perform SQL injection and how to safeguard against it.

## Description

This project consists of a simple software that connects to a MySQL database, retrieves user input, queries the database based on the input, and displays the results. The software is demonstrated in three tasks:

1. **Code without SQL Injection Protection:**
   - Establishes a connection to a MySQL database. 📡
   - Prompts the user to enter a name. 📝
   - Constructs and executes a SQL query with the user input. 🛠️
   - Displays the results. 📋
   - Highlights the vulnerability to SQL injection attacks. ⚠️

2. **Code with SQL Injection Attack:**
   - Demonstrates how an attacker can exploit the software by injecting SQL code through the input field. 🕵️‍♂️
   - Constructs a malicious SQL query to retrieve all records from the database. 🚨
   - Shows how sensitive data can be exposed. 🔓

3. **Code with SQL Injection Protection using PreparedStatements:**
   - Utilizes PreparedStatement to securely handle user input. 🔒
   - Prepares SQL queries with parameters to prevent SQL injection. 🛡️
   - Demonstrates that even with malicious input, the database remains protected. ✅
