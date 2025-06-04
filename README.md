# PLACEMENT-HELP-APPLICATION
The Placement Help Application is a web-based platform designed to bridge the information gap between students and alumni in the context of campus placements. It enables students to access company-wise placement experiences, post queries, and receive insights from alumni. Admins (faculty/coordinators) moderate and maintain the platform for accuracy and safety.

# MAIN FEATURES
1)Student Features
Search for alumni experiences and company-specific placement data.
Post queries related to interviews, roles, etc.
Upvote helpful content to prioritize high-quality responses.
Follows MVC architecture, uses Spring Boot with clear layering (Controller, Service, Repository, etc.).

2)Alumni Features
Submit interview experiences categorized by company and year.
Answer student queries directly.
Acts as a knowledge-sharing contributor.
Uses MVC pattern with additional patterns like Command, Iterator, and Chain of Responsibility to manage data flow and services.

3)Admin Features
Moderate content (add/edit/delete experiences or queries).
Manage placement stats via a dedicated backend interface.
Uses MVC and DTO patterns to structure API responses and ensure data validation.

4)Login & Security
Spring Security with role-based access for Student, Alumni, and Admin.
Custom login flow with redirection based on user roles.
Patterns used include Strategy, Template Method, and Repository.
