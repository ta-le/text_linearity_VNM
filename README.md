The Inherent Linear-Separability of Text-Data in the Vietnamese Language
=========

In text-classification tasks for the English language, there is a long-standing heuristic often quoted without proof: 
_"Text Data in inherently linearly-separable."_ 
The main goal of this project is to prove if this heuristic still holds in the Vietnamese language, both empirically and theoretically.

**Remark**: 
In this project, we did not seek to prove the text-book definition of linear-separability, as there is no such pattern in the real-world. What we tried to prove is: **"There exists a good-enough hyperplane to serve as a classifier for our text-data."**

## Overview of the Project

This project is submitted as the final project for a graduate-level course in **Text Mining** at [John von Neumann Institute - Vietnam's National University at HCMC][1]. It received the only perfect score of the class from [Professor Tru Cao][2].

The **empirical part** of this project is developed by me and 2 other teammates, [Minh Bach][3] and [Quang Nguyen][4] **(1)**. 

The main idea is to conduct an **SVM-test** using 3 SVM classifiers, one is simple (Linear-Kernel with Word-Threshold feature-selection) and the other two are complex (RBF-Kernel with Word-Threshold / Mutual-Information feature-selection); if we arrive at a comparable high-performance between the 3 classifiers, then the conclusion is positive. **(2)**

The **theoretical part** of this project is developed by me based on the theoretical foundations laid out in [[Thorsten Joachims, 1997][5]] **(3)**. The main idea consisted of 3 parts:
1. Tighten the VC generalization bound to derive generalization using our good empirical result.
2. Used the distribution-free VC-bound of SVM, in the hypothesis-space of hyperplanes, as the starting inequality.
3. To tighten this bound, we assume one property about the distribution of text-data: **"highly-dimensional with few irrelevant features."** **(4)**

**Remarks**:

**(1)** - We, of course, used things developed by other people:
- A Java library for Text-Segmentation: https://github.com/vncorenlp/VnCoreNLP
- A list of Vietnamese stop words: https://github.com/stopwords/vietnamese-stopwords
- An intensive dataset of Vietnamese news built by our friend: https://github.com/atuanpham/news-data

**(2)** - We, of course, justified each of our steps in the empirical experiment to make sure that the evidence is non-bias and representative. Please kindly refer to the file - [[EMPIRICAL]_REPORT_Text-Mining.pdf][6] - for the details, this is the actual report we submitted for grading.

**(3)** - Please be aware that this is not a rigorous theoretical proof since such proof is very hard given my understandings of **Learning Theory** at that time. However, it is a good intuitive explanation, as judged by the Professor, for why the empirical evidence generalizes. Please kindly refer to the file - [[THEORY]_cut_from_presentation.pdf][7] - for the original proof slides presented to the Professor. 

**(4)** - This may be a reasonable assumption in most text-classification tasks, where the appearance or not of some words in a text is enough to determine its type (such as this one - binary-classify if a news text is Technology or Not-Technology). In more complex classification tasks, such as sentiment analysis, this is not the case anymore and **the long-standing heuristic may not hold true**.

## On the details of the Theoretical Justification

As you may notice, the theoretical part wasn't written down in the report; only its sketch was presented in the slides. This was because of coherence reasons since the report was supposed only to include experimental details. 
However, I'm planning to write down its details and include here for future references (if time permits).

##### Thank you for taking your time reading this note.


[1]: http://www.jvn.edu.vn/
[2]: https://scholar.google.com/citations?user=PelFHGwAAAAJ
[3]: https://www.linkedin.com/in/quang-minh-bach-469a52107/
[4]: https://www.linkedin.com/in/qn-nguyen/
[5]: https://www.cs.cornell.edu/people/tj/publications/joachims_98a.pdf
[6]: https://github.com/ta-le/text_linearity_VNM/blob/master/%5BEMPIRICAL%5D_REPORT_Text-Mining.pdf
[7]: https://github.com/ta-le/text_linearity_VNM/blob/master/%5BTHEORY%5D_cut_from_presentation.pdf

