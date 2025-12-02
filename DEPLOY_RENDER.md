# Gastini Backend - Guía de Despliegue en Render

## 🚀 Despliegue en Render

### Paso 1: Preparar el repositorio

1. Asegúrate de que todos los archivos estén en tu repositorio de Git:
   - `Dockerfile`
   - `.dockerignore`
   - Código fuente

2. Haz commit y push de los cambios:
```bash
git add .
git commit -m "Add Dockerfile for Render deployment"
git push
```

### Paso 2: Crear el servicio en Render

1. Ve a [Render Dashboard](https://dashboard.render.com/)
2. Click en **"New +"** → **"Web Service"**
3. Conecta tu repositorio de GitHub/GitLab
4. Selecciona el repositorio `gastini-back`

### Paso 3: Configurar el servicio

**Configuración básica:**
- **Name:** `gastini-backend` (o el nombre que prefieras)
- **Region:** Elige la más cercana (ej: `Oregon (US West)`)
- **Branch:** `main` (o tu rama principal)
- **Runtime:** `Docker`
- **Instance Type:** `Free` (para empezar)

### Paso 4: Variables de entorno

En la sección **Environment Variables**, agrega:

#### Para usar H2 (base de datos en memoria - solo desarrollo):
```
H2_CONSOLE_ENABLED=false
SHOW_SQL=false
FORMAT_SQL=false
```

#### Para usar PostgreSQL (RECOMENDADO para producción):

1. Primero crea una base de datos PostgreSQL en Render:
   - Click en **"New +"** → **"PostgreSQL"**
   - Nombre: `gastini-db`
   - Copia la **Internal Database URL**

2. Agrega estas variables de entorno:
```
DATABASE_URL=<tu-internal-database-url-de-render>
DB_DRIVER=org.postgresql.Driver
DB_DIALECT=org.hibernate.dialect.PostgreSQLDialect
DDL_AUTO=update
SHOW_SQL=false
FORMAT_SQL=false
```

### Paso 5: Desplegar

1. Click en **"Create Web Service"**
2. Render automáticamente:
   - Detectará el Dockerfile
   - Construirá la imagen
   - Desplegará la aplicación
3. Espera a que el build termine (puede tomar 5-10 minutos la primera vez)

### Paso 6: Obtener la URL

Una vez desplegado, Render te dará una URL como:
```
https://gastini-backend.onrender.com
```

### Paso 7: Actualizar CORS

Actualiza el archivo `CorsConfig.java` para incluir tu URL de Render:

```java
config.setAllowedOriginPatterns(Arrays.asList(
    "http://localhost:3000",
    "https://gastini.vercel.app",
    "https://gastini-backend.onrender.com"  // Tu URL de Render
));
```

Haz commit y push de este cambio. Render se redespliegará automáticamente.

### Paso 8: Actualizar el Frontend

En tu proyecto de Vercel, actualiza la URL del API:

```javascript
const API_BASE = process.env.NEXT_PUBLIC_API_URL || 'https://gastini-backend.onrender.com';
```

Y configura la variable de entorno en Vercel:
```
NEXT_PUBLIC_API_URL=https://gastini-backend.onrender.com
```

## 🔧 Troubleshooting

### El servicio no inicia
- Revisa los logs en Render Dashboard
- Verifica que todas las variables de entorno estén configuradas
- Asegúrate de que el puerto esté configurado correctamente (Render usa la variable `PORT`)

### Errores de base de datos
- Si usas PostgreSQL, verifica que la `DATABASE_URL` sea correcta
- Asegúrate de usar la **Internal Database URL** (no la External)

### El servicio se duerme (plan Free)
- En el plan gratuito, Render pone el servicio en "sleep" después de 15 minutos de inactividad
- La primera petición después del sleep puede tardar 30-60 segundos
- Considera actualizar a un plan de pago si necesitas disponibilidad 24/7

## 📝 Notas

- **Plan Free:** 750 horas/mes, el servicio se duerme después de 15 min de inactividad
- **Base de datos:** PostgreSQL gratuito tiene 90 días de retención
- **Builds:** Automáticos en cada push a la rama principal
- **Logs:** Disponibles en tiempo real en el dashboard

## 🔗 Enlaces útiles

- [Documentación de Render](https://render.com/docs)
- [Render Status](https://status.render.com/)
- [Comunidad de Render](https://community.render.com/)
