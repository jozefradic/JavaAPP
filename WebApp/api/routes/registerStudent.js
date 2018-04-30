const express = require('express');
const router = express.Router();

//Import controller
const regStudentController = require('../controller/registerStudent');


router.get('/', regStudentController.get_student_reg_form);
router.post('/', regStudentController.register_new_student);

module.exports = router;