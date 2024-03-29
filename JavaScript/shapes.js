/*
 * This module defines/generates vertex arrays for certain predefined shapes.
 * The "shapes" are returned as indexed vertices, with utility functions for
 * converting these into "raw" coordinate arrays.
 */
var Shapes = {
    /*
     * Returns the vertices for a small icosahedron.
     */
    icosahedron: function () {
        // These variables are actually "constants" for icosahedron coordinates.
        var X = 0.525731112119133606,
            Z = 0.850650808352039932;

        return {
            vertices: [
                [ -X, 0.0, Z ],
                [ X, 0.0, Z ],
                [ -X, 0.0, -Z ],
                [ X, 0.0, -Z ],
                [ 0.0, Z, X ],
                [ 0.0, Z, -X ],
                [ 0.0, -Z, X ],
                [ 0.0, -Z, -X ],
                [ Z, X, 0.0 ],
                [ -Z, X, 0.0 ],
                [ Z, -X, 0.0 ],
                [ -Z, -X, 0.0 ]
            ],

            indices: [
                [ 1, 4, 0 ],
                [ 4, 9, 0 ],
                [ 4, 5, 9 ],
                [ 8, 5, 4 ],
                [ 1, 8, 4 ],
                [ 1, 10, 8 ],
                [ 10, 3, 8 ],
                [ 8, 3, 5 ],
                [ 3, 2, 5 ],
                [ 3, 7, 2 ],
                [ 3, 10, 7 ],
                [ 10, 6, 7 ],
                [ 6, 11, 7 ],
                [ 6, 0, 11 ],
                [ 6, 1, 0 ],
                [ 10, 1, 6 ],
                [ 11, 0, 9 ],
                [ 2, 11, 9 ],
                [ 5, 2, 9 ],
                [ 11, 2, 7 ]
            ]
        };
    },

    /*
     * Utility function for turning indexed vertices into a "raw" coordinate array
     * arranged as triangles.
     */
    toRawTriangleArray: function (indexedVertices) {
        var result = [],
            i,
            j,
            maxi,
            maxj;

        for (i = 0, maxi = indexedVertices.indices.length; i < maxi; i += 1) {
            for (j = 0, maxj = indexedVertices.indices[i].length; j < maxj; j += 1) {
                result = result.concat(
                    indexedVertices.vertices[
                        indexedVertices.indices[i][j]
                    ]
                );
            }
        }

        return result;
    },

    /*
     * Utility function for turning indexed vertices into a "raw" coordinate array
     * arranged as line segments.
     */
    toRawLineArray: function (indexedVertices) {
        var result = [],
            i,
            j,
            maxi,
            maxj;

        for (i = 0, maxi = indexedVertices.indices.length; i < maxi; i += 1) {
            for (j = 0, maxj = indexedVertices.indices[i].length; j < maxj; j += 1) {
                result = result.concat(
                    indexedVertices.vertices[
                        indexedVertices.indices[i][j]
                    ],

                    indexedVertices.vertices[
                        indexedVertices.indices[i][(j + 1) % maxj]
                    ]
                );
            }
        }

        return result;
    },
    
    sphereBody: function() {
    	var DegreesToRadians = Math.PI / 180.0;
    	var quad_data = new Array(),
    		i = 0,
    		phi = -80.0,
    		phir, phir20, theta, thetar;
    	
    	for (i; phi <= 80.0; phi += 3.0) {
    		phir = phi * DegreesToRadians;
    		phir20 = (phi + 20.0) * DegreesToRadians;
    		
    		for (theta = -180.0; theta <= 180.0; theta += 3.0) {
    			thetar = theta * DegreesToRadians;
    			quad_data[i] = Math.sin(thetar) * Math.cos(phir);
    			i++;
    			quad_data[i] = Math.cos(thetar) * Math.cos(phir);
    			i++;
    			quad_data[i] = Math.sin(phir);
    			i++;
    			
    			quad_data[i] = Math.sin(thetar) * Math.cos(phir20);
    			i++;
    			quad_data[i] = Math.cos(thetar) * Math.cos(phir20);
    			i++;
    			quad_data[i] = Math.sin(phir20);
    			i++;
    		}
    	} 
    	return quad_data;
    },
    
    spherePoleFirst: function() {
    	var DegreesToRadians = Math.PI/ 180.0;
    	var i = 0,
    	strip_data = new Array();
    	
    	strip_data[i] = 0.0;
    	i++;
    	strip_data[i] = 0.0;
    	i++;
    	strip_data[i] = 1.0;
    	i++;
    	
    	var sin80 = Math.sin(80.0 * DegreesToRadians);
    	var cos80 = Math.cos(80.0 * DegreesToRadians);
    	
    	for (var theta = -180.0; theta <= 180.0; theta += 3.0) {
    		var thetar =  theta * DegreesToRadians;
    		strip_data[i] = Math.sin(thetar) * cos80;
    		i++;
    		strip_data[i] = Math.cos(thetar) * cos80;
    		i++;
    		strip_data[i] = sin80;
    		i++;
    	}
    	return strip_data;
    },
    
    spherePoleSecond: function() {
    	var DegreesToRadians = Math.PI/ 180.0;
    	var i = 0,
    	strip_data = new Array();
    	
    	strip_data[i] = 0.0;
    	i++;
    	strip_data[i] = 0.0;
    	i++;
    	strip_data[i] = 1.0;
    	i++;
    	
    	var sin80 = Math.sin(80.0 * DegreesToRadians);
    	var cos80 = Math.cos(80.0 * DegreesToRadians);
    	
    	for (var theta = -180.0; theta <= 180.0; theta += 3.0) {
    		var thetar =  theta * DegreesToRadians;
    		strip_data[i] = Math.sin(thetar) * cos80;
    		i++;
    		strip_data[i] = Math.cos(thetar) * cos80;
    		i++;
    		strip_data[i] = -sin80;
    		i++;
    	}
    	return strip_data;
    }
};
