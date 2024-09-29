
# Etapa 1: Compilar la aplicación Angular
FROM node:16-alpine AS build
WORKDIR /app
COPY package.json package-lock.json ./
RUN npm install
COPY . .
RUN npm run build --prod

# Etapa 2: Servir la aplicación con un servidor Nginx
FROM nginx:alpine
COPY --from=build /app/dist/parqueadero-frontend /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
