# Stage 1: Build the Angular app
FROM node:14.20.0 AS build

RUN mkdir -p /app2

WORKDIR /app2

COPY package.json /app2/

RUN npm install

COPY . /app2/

RUN npm run build --prod


# Stage 2: Serve the built Angular app with nginx
FROM nginx:1.21.3

COPY --from=build /app/dist/tiptop /usr/share/nginx/html

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
