# Stage 1
FROM node:10-alpine as builder

# Make another directory to build in
RUN mkdir -p /app 
WORKDIR /app

# Copy package.json into /app and then install to get dependencies.
COPY package.json /app

# Add the app
COPY . /app

# Install dependencies
RUN npm install

# Generate the build of the application --prod --base-href=''
RUN npm run build 

# Stage 2
FROM nginx:1.17.1-alpine
COPY --from=builder /app/dist/harry-potter-api-ui /usr/share/nginx/html
COPY --from=builder /app/nginx.conf /etc/nginx/conf.d/default.conf

# Expose port 80
EXPOSE 80