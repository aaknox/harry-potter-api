# The Harry Potter Magical Social Site
## About the API
The API in use for project: https://hp-api.herokuapp.com/

This API only has 4 endpoints:
- http://hp-api.herokuapp.com/api/characters - view all characters
- http://hp-api.herokuapp.com/api/characters/students - view all characters who are Hogwarts students during the book series
- http://hp-api.herokuapp.com/api/characters/staff - view all characters who are Hogwarts staff during the book series
- http://hp-api.herokuapp.com/api/characters/house/:house - view all characters in a certain house, e.g. /slytherin

Credits to the API's creators. See the original GitHub repo for this API [here](https://github.com/bethfraser/hp-api).

## User Stories
### User Experience:
- User must be able to create a profile when visiting the site for the first time.
- User should be able to securely login into website through OAuth authentication.
- User should be able to retrieve a character's information based on their name or their gender or their house via search bar.
- User is able to edit their profile and user settings to personalize their experience on the website.
- User should be able to post a blog on their personal pages.
- User should be able to edit & delete their own blogs and comments.
- User should be able to make a comment on another person's blog.
- User is able to flag comments that are inappropriate or erroneous for admins to review.
- User should be able to submit a new character request.

### Admin Experience:
- Admin can remove inappropriate comment on blog posts.
- Admin can approve or revoke any flagged comments.
- Admin can ban users from the site
- Admin can accept or decline new character requests.

## Stretch Goals:
### Wizard Chess Game:
- User should be able to play a round of wizard chess with another logged-in user.
- User is able to communicate with other users through a chatroom feature.
- User should be able to see the leaderboard of the highest scores.

### Sorting Hat:
- User should be randomly assigned a house for their profiles.
- User should be able to receive house points based on their online activities.
- User should be able to see who is leading to get the House Cup via a monthly email notification.

## Objectives
### Quality/Testing:
- The application goes through unit tests on each backend service.
- The application also has intergration testing and e2e testing on frontend.
- Test Coverage above 80% and code smells below 10%
- Messaging queues between microservices and logging of all activities
- Load balancing for deploying website into production
- Optimal security for development and release pipelines


## Technologies being used:
- Angular
- Bootstrap
- BurmaJS
- GSAP
- MagicScroll
- Karma
- Jasmine
- Proctorer
- Java 11
- Maven
- SonarCloud
- Azure DevOps
- Ingress
- Docker
- Kubernetes
- OAuth
- Agile/Scrum methodologies