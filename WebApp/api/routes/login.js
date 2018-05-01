const express = require('express');
const router = express.Router();
const session = require('express-session');
const passport = require('passport');
const LocalStrategy = require('passport-local').strategy;
const flash = require('connect-flash');

//Import controller
const loginController = require('../controller/login');


router.get('/', loginController.index_get);
router.post('/login',loginController.login);
router.get('/logout', loginController.logout);


module.exports = router;