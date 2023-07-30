# Set the base image
FROM node:18

# Set the working directory
WORKDIR /app

# Copy package.json and yarn.lock
COPY package.json yarn.lock ./

# Install project dependencies
RUN yarn install

# Copy the rest of your app's source code
COPY . ./

# Build for production
RUN yarn build

# Start server
CMD ["yarn", "start"]