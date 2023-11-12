# Stage 1: Build the Angular app
FROM node:14.20.0 AS build

RUN mkdir -p /app
WORKDIR /app

COPY package.json /app/

# Debugging: Print the contents of the package.json file
RUN cat package.json

RUN npm install

COPY . /app/

# Debugging: Print the list of files in the /app directory
RUN ls -al

# Build the Angular app with the --prod flag
RUN npm run build 

# Stage 2: Serve the built Angular app with nginx
FROM nginx:1.21.3

COPY --from=build /app/dist/tiptop /usr/share/nginx/html

EXPOSE 80

# Start Nginx with daemon off
CMD ["nginx", "-g", "daemon off;"]
