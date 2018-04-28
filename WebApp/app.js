//Essential requirments
const express = require('express');
const app = express();

//DB connection
const mysql = require('mysql');

//Extension packages
const exphbs = require('express-handlebars');
const path = require('path');

//Port
const port = process.env.PORT || 5000;

//App
//Routes
const index = require('./api/routes/index');
//const teacher = require('./api/routes/teacher');
//const student = require('./api/routes/student');

app.use('/',index);
//app.use('/regteacher', teacher);
//app.use('/regstudent', student);

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