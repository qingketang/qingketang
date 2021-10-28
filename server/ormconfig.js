module.exports = {
    "type": "mysql",
    "host": process.env.DB_HOST,
    "port": process.env.DB_PORT,
    "username": process.env.DB_USER,
    "password": process.env.DB_PASS,
    "database": process.env.DB_NAME,
    "synchronize": false,
    "logging": false,
    "entities": ["dist/entity/**/*.js"],
    "migrations": ["dist/migration/**/*.js"],
    "subscribers": ["dist/subscriber/**/*.js"]
}
