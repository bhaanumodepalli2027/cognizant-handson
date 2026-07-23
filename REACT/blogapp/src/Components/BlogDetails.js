import React, { Component } from "react";

class BlogDetails extends Component {
  constructor() {
    super();

    this.state = {
      blogs: [
        {
          id: 1,
          title: "About Cognizant",
          content:
            "Cognizant is a global IT services and consulting company that provides digital, technology, consulting, and operations services."
        },
        {
          id: 2,
          title: "Digital Nurture Program",
          content:
            "Digital Nurture is Cognizant's learning program that helps students and freshers gain hands-on experience in Java, React, Spring Boot, Angular, SQL, and Cloud technologies."
        },
        {
          id: 3,
          title: "Career Opportunities",
          content:
            "Cognizant recruits graduates for roles such as Programmer Analyst, Software Engineer, Full Stack Developer, and Cloud Engineer."
        },
        {
          id: 4,
          title: "Technologies",
          content:
            "Cognizant works with Java, React, Angular, .NET, Python, AI, Machine Learning, Cloud, DevOps, and Data Engineering."
        },
        {
          id: 5,
          title: "Mission",
          content:
            "Cognizant helps clients modernize technology, reimagine business processes, and deliver better digital experiences."
        }
      ]
    };
  }

  render() {
    return (
      <div style={{ padding: "20px" }}>
        <h1>Cognizant Details</h1>

        {this.state.blogs.map((blog) => (
          <div
            key={blog.id}
            style={{
              border: "1px solid #000",
              borderRadius: "8px",
              padding: "10px",
              marginBottom: "15px"
            }}
          >
            <h2>{blog.title}</h2>
            <p>{blog.content}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default BlogDetails;