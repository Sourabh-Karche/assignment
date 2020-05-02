There are 2 microservices:
	1. Auth:
		Auth service will validate user with username and password. There are two users created 
			User1: username: admin, password: password
			User2: username: admin1, password: password
			eg: JSON => {
				"username": "admin",
				"password": "password"
			}
			
			Will send response containing username and userId.
	2. Profile:
		Profile Service will use userId to get or delete the respective profile. And will use Profile json to save or update the respective profile.
		

Base: Contains commons for Auth and Profile services.

UI: An angular project. Will act as a UI to the project.
	Steps:
		1. npm install . command in UI folder where package.json file is present.
		2. ng serve to run the UI project.
		3. UI project will run on http://localhost:4200