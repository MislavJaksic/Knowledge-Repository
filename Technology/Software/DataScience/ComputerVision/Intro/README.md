## Introduction to Computer Vision

Computer vision is an area of study that is trying to make computers detect what the picture shows.  

### Digital pictures

A digital picture is made of discrete points called pixels.  
You can think of a picture as a two dimensional array or a hilly three dimensional plane.  
If a picture has colour, each pixel has three values, red, blue and green. These values range from 0 to 255.  
If a picture is colourless (grayscale), each pixel will have only one value.  
Pixel values are sometimes called intensities.  

A grayscale picture made up of four pixels:  
```
+-----+-----+  
| 090 | 055 |  
+-----+-----+  
| 000 | 155 |  
+-----+-----+  
```

### Naive picture comparison

A naive way of comparing pictures is to compare them pixel by pixel. This method only works if the pictures are identical.  
If one picture is slightly rotated or a scaled version of the other picture, then the comparison isn't going to work.  
The naive method cannot identify the subject of the picture (an aeroplane, an aerodrome, a person or ...?).  

### Smart picture comparison

Pictures can be compared by first describing a distinct area of a picture in such a way that it can be compared with other areas in other pictures.  
The comparsion is executed in three steps:  
1) In the detection step, the algorithm tries to find destinct pixels in the picture;  
2) In the description step, the area around the distinct pixels is described;  
3) In the matching step, described areas are compared.  

### Detector step

Before an area of a picture can be described, distinct pixels have to be found.  
These distinct pixels are called interest points or keypoints.  
Distinct pixels are found using a detector, an algorithm that searches for interest points.  
Distinct points are most commonly found around blobs, T-junctions and corners.  
The most important feature of a detector is its reliability. Detector reliability is a measure of how often
it can find a distinct point in a picture even if the viewing condictions are slightly changed.  

### Descriptor step

After distinct points have been found, the area around each one must be described before they can be described.  
Description is performed by a descriptor, an algorithm that will create a feature vector, a one by N matrix, where N is the number of features.  
A feature vector is geometrically interpreted as a point in N dimensional space.  
Feature vectors have to be distinct and robust to noise, yet they should have only a small number of features.  
Features hold the information that describe the area around the distinct point.  

### Matching step

After feature vectors have been created, they are matched againt other feature vectors that have been extracted from other picture.  
If a feature vectors have many features, this step will take a long time to compute.  
Feature vectors (data points in N dimensional space) are matched based on distance from each other only if they are above a cetain threshold.  
