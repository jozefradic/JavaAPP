const express = require('express');
const router = express.Router();

//Import controller
const indexController = require('../controller/index');


router.get('/', indexController.index_get);


module.exports = router;