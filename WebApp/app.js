const Express = require('express');
const app = Express();
const mysql = require('mysql');

const db = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'sovylearn'
  })
  
  db.connect((err) => {
    if(err){
      throw err;
    }
    console.log('mysql connected');
  });
  
  app.get('/',(req,res) => {
    let sql = 'select content->"$.Question1.text" as Question1 from tests;'
    db.query(sql, (err,result) => {
      if(err){
        throw err;
      }
      res.send(result);
      
    });
  
  });

app.listen(3000, () => {
    console.log('server started');
})