/*
* The beginnings of my implementation of a graphics math library
*/

//Creates a 4x4 Matrix that is really just an array with 16 items
var Matrix4x4 = function () {
    // Default to the identity matrix (column major).
    this.contents = [
        1, 0, 0, 0,
        0, 1, 0, 0,
        0, 0, 1, 0,
        0, 0, 0, 1
    ];
};

//Multiplies 2 4x4 matrices. I saw your code in matrix4x4.js and I did not want to 
//copy the logic behind it so I just decided to hardcode the values.
Matrix4x4.prototype.multiply = function (matrix) {
    var returnMatrix = new Matrix4x4();
    
    returnMatrix.contents[0] = 
        (this.contents[0] * matrix.contents[0]) + 
        (this.contents[1] * matrix.contents[4]) + 
        (this.contents[2] * matrix.contents[8]) + 
        (this.contents[3] * matrix.contents[12]);

    returnMatrix.contents[1] = 
        (this.contents[0] * matrix.contents[1]) + 
        (this.contents[1] * matrix.contents[5]) + 
        (this.contents[2] * matrix.contents[9]) + 
        (this.contents[3] * matrix.contents[13]);
        
    returnMatrix.contents[2] = 
        (this.contents[0] * matrix.contents[2]) + 
        (this.contents[1] * matrix.contents[6]) + 
        (this.contents[2] * matrix.contents[10]) + 
        (this.contents[3] * matrix.contents[14]);
        
    returnMatrix.contents[3] = 
        (this.contents[0] * matrix.contents[3]) + 
        (this.contents[1] * matrix.contents[7]) + 
        (this.contents[2] * matrix.contents[11]) + 
        (this.contents[3] * matrix.contents[15]);
    
    returnMatrix.contents[4] = 
        (this.contents[4] * matrix.contents[0]) + 
        (this.contents[5] * matrix.contents[4]) + 
        (this.contents[6] * matrix.contents[8]) + 
        (this.contents[7] * matrix.contents[12]);
        
    returnMatrix.contents[5] = 
        (this.contents[4] * matrix.contents[1]) + 
        (this.contents[5] * matrix.contents[5]) + 
        (this.contents[6] * matrix.contents[9]) + 
        (this.contents[7] * matrix.contents[13]);
        
    returnMatrix.contents[6] = 
        (this.contents[4] * matrix.contents[2]) + 
        (this.contents[5] * matrix.contents[6]) + 
        (this.contents[6] * matrix.contents[10]) + 
        (this.contents[7] * matrix.contents[14]);
        
    returnMatrix.contents[7] = 
        (this.contents[4] * matrix.contents[3]) + 
        (this.contents[5] * matrix.contents[7]) + 
        (this.contents[6] * matrix.contents[11]) + 
        (this.contents[7] * matrix.contents[15]);
    
    returnMatrix.contents[8] = 
        (this.contents[8] * matrix.contents[0]) + 
        (this.contents[9] * matrix.contents[4]) + 
        (this.contents[10] * matrix.contents[8]) + 
        (this.contents[11] * matrix.contents[12]);
    
    returnMatrix.contents[9] = 
        (this.contents[8] * matrix.contents[1]) + 
        (this.contents[9] * matrix.contents[5]) + 
        (this.contents[10] * matrix.contents[9]) + 
        (this.contents[11] * matrix.contents[13]);
        
    returnMatrix.contents[10] = 
        (this.contents[8] * matrix.contents[2]) + 
        (this.contents[9] * matrix.contents[6]) + 
        (this.contents[10] * matrix.contents[10]) + 
        (this.contents[11] * matrix.contents[14]);
        
    returnMatrix.contents[11] = 
        (this.contents[8] * matrix.contents[3]) + 
        (this.contents[9] * matrix.contents[7]) + 
        (this.contents[10] * matrix.contents[11]) + 
        (this.contents[11] * matrix.contents[15]);

    returnMatrix.contents[12] = 
        (this.contents[12] * matrix.contents[0]) + 
        (this.contents[13] * matrix.contents[4]) + 
        (this.contents[14] * matrix.contents[8]) + 
        (this.contents[15] * matrix.contents[12]);
    
    returnMatrix.contents[13] = 
        (this.contents[12] * matrix.contents[1]) + 
        (this.contents[13] * matrix.contents[5]) + 
        (this.contents[14] * matrix.contents[9]) + 
        (this.contents[15] * matrix.contents[13]);
        
    returnMatrix.contents[14] = 
        (this.contents[12] * matrix.contents[2]) + 
        (this.contents[13] * matrix.contents[6]) + 
        (this.contents[14] * matrix.contents[10]) + 
        (this.contents[15] * matrix.contents[14]);
        
    returnMatrix.contents[15] = 
        (this.contents[12] * matrix.contents[3]) + 
        (this.contents[13] * matrix.contents[7]) + 
        (this.contents[14] * matrix.contents[11]) + 
        (this.contents[15] * matrix.contents[15]);
        
    return returnMatrix;
};

//Takes in three parameters dx, dy, and dz and outputs a matrix
//that has been effected by the given changes.
Matrix4x4.prototype.translate = function (dx, dy, dz) {
    this.contents[12] +=
        this.contents[0] * dx + 
        this.contents[4] * dy + 
        this.contents[8] * dz;
        
    this.contents[13] += 
        this.contents[1] * dx + 
        this.contents[5] * dy + 
        this.contents[9] * dz;
        
    this.contents[14] += 
        this.contents[2] * dx + 
        this.contents[6] * dy + 
        this.contents[10] * dz;
        
    this.contents[15] += 
        this.contents[3] * dx + 
        this.contents[7] * dy + 
        this.contents[11] * dz;

    return this;
};

//Takes in three parameters dx, dy, and dz and outputs a matrix
//that has been effected by the given scale changes.
Matrix4x4.prototype.scale = function (sx, sy, sz) {
    this.contents[0] *= sx;
    this.contents[1] *= sx;
    this.contents[2] *= sx;
    this.contents[3] *= sx;

    this.contents[4] *= sy;
    this.contents[5] *= sy;
    this.contents[6] *= sy;
    this.contents[7] *= sy;

    this.contents[8] *= sz;
    this.contents[9] *= sz;
    this.contents[10] *= sz;
    this.contents[11] *= sz;

    return this;
};
