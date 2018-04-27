const Express = require('express');
const app = Express();
const mysql = require('mysql');

app.listen(3000, () => {
    console.log('server started');
})