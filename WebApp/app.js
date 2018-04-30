
//Environment variables
require('dotenv').config();

//Essential requirments
const express = require('express');
const app = express();

//DB connection
const db = require('./api/models/db');

//Extension packages
const exphbs = require('express-handlebars');
const path = require('path');
const bodyParser = require('body-parser');


app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json()); 

//Port
 const port = process.env.PORT || 5000;

//App
//Routes
const index = require('./api/routes/index');
const registerStudent = require('./api/routes/registerStudent');
//const teacher = require('./api/routes/teacher');
//const student = require('./api/routes/student');

app.use('/',index);
app.use('/registerStudent', registerStudent);
//app.use('/regteacher', teacher);


//view engine
app.engine('handlebars',exphbs({defaultLayout: 'main'}));
app.set('view engine', 'handlebars');


//Static path
app.use(express.static(path.join(__dirname+'.../public')));

//Global var for user
app.use((req,res,next)=>{
    res.locals.admin = req.admin || null;
    next();
});


app.listen(port, () => {
    console.log('SERVER STARTED ON PORT '+port);
})